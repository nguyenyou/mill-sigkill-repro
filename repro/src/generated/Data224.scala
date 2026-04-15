package generated

final case class Data224(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data224 = copy(name = name.toUpperCase)
  def scale(k: Double): Data224 = copy(value = value * k)
  def addTag(t: String): Data224 = copy(tags = t :: tags)
  def put(k: String, v: String): Data224 = copy(meta = meta.updated(k, v))
  def merge(other: Data224): Data224 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data224 {
  given Ordering[Data224] = Ordering.by(_.id)
  def empty: Data224 = Data224(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data224 =
    Data224(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data224] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
