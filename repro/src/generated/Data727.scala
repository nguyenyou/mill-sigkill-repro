package generated

final case class Data727(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data727 = copy(name = name.toUpperCase)
  def scale(k: Double): Data727 = copy(value = value * k)
  def addTag(t: String): Data727 = copy(tags = t :: tags)
  def put(k: String, v: String): Data727 = copy(meta = meta.updated(k, v))
  def merge(other: Data727): Data727 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data727 {
  given Ordering[Data727] = Ordering.by(_.id)
  def empty: Data727 = Data727(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data727 =
    Data727(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data727] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
