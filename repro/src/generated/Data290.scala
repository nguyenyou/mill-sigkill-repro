package generated

final case class Data290(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data290 = copy(name = name.toUpperCase)
  def scale(k: Double): Data290 = copy(value = value * k)
  def addTag(t: String): Data290 = copy(tags = t :: tags)
  def put(k: String, v: String): Data290 = copy(meta = meta.updated(k, v))
  def merge(other: Data290): Data290 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data290 {
  given Ordering[Data290] = Ordering.by(_.id)
  def empty: Data290 = Data290(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data290 =
    Data290(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data290] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
