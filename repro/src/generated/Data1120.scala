package generated

final case class Data1120(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1120 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1120 = copy(value = value * k)
  def addTag(t: String): Data1120 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1120 = copy(meta = meta.updated(k, v))
  def merge(other: Data1120): Data1120 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1120 {
  given Ordering[Data1120] = Ordering.by(_.id)
  def empty: Data1120 = Data1120(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1120 =
    Data1120(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1120] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
