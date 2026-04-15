package generated

final case class Data1290(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1290 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1290 = copy(value = value * k)
  def addTag(t: String): Data1290 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1290 = copy(meta = meta.updated(k, v))
  def merge(other: Data1290): Data1290 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1290 {
  given Ordering[Data1290] = Ordering.by(_.id)
  def empty: Data1290 = Data1290(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1290 =
    Data1290(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1290] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
