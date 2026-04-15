package generated

final case class Data404(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data404 = copy(name = name.toUpperCase)
  def scale(k: Double): Data404 = copy(value = value * k)
  def addTag(t: String): Data404 = copy(tags = t :: tags)
  def put(k: String, v: String): Data404 = copy(meta = meta.updated(k, v))
  def merge(other: Data404): Data404 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data404 {
  given Ordering[Data404] = Ordering.by(_.id)
  def empty: Data404 = Data404(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data404 =
    Data404(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data404] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
