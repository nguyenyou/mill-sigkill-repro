package generated

final case class Data1473(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1473 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1473 = copy(value = value * k)
  def addTag(t: String): Data1473 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1473 = copy(meta = meta.updated(k, v))
  def merge(other: Data1473): Data1473 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1473 {
  given Ordering[Data1473] = Ordering.by(_.id)
  def empty: Data1473 = Data1473(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1473 =
    Data1473(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1473] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
