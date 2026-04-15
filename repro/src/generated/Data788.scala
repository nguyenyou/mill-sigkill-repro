package generated

final case class Data788(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data788 = copy(name = name.toUpperCase)
  def scale(k: Double): Data788 = copy(value = value * k)
  def addTag(t: String): Data788 = copy(tags = t :: tags)
  def put(k: String, v: String): Data788 = copy(meta = meta.updated(k, v))
  def merge(other: Data788): Data788 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data788 {
  given Ordering[Data788] = Ordering.by(_.id)
  def empty: Data788 = Data788(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data788 =
    Data788(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data788] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
