package generated

final case class Data194(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data194 = copy(name = name.toUpperCase)
  def scale(k: Double): Data194 = copy(value = value * k)
  def addTag(t: String): Data194 = copy(tags = t :: tags)
  def put(k: String, v: String): Data194 = copy(meta = meta.updated(k, v))
  def merge(other: Data194): Data194 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data194 {
  given Ordering[Data194] = Ordering.by(_.id)
  def empty: Data194 = Data194(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data194 =
    Data194(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data194] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
