package generated

final case class Data77(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data77 = copy(name = name.toUpperCase)
  def scale(k: Double): Data77 = copy(value = value * k)
  def addTag(t: String): Data77 = copy(tags = t :: tags)
  def put(k: String, v: String): Data77 = copy(meta = meta.updated(k, v))
  def merge(other: Data77): Data77 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data77 {
  given Ordering[Data77] = Ordering.by(_.id)
  def empty: Data77 = Data77(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data77 =
    Data77(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data77] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
