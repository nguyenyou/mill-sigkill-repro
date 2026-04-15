package generated

final case class Data1277(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1277 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1277 = copy(value = value * k)
  def addTag(t: String): Data1277 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1277 = copy(meta = meta.updated(k, v))
  def merge(other: Data1277): Data1277 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1277 {
  given Ordering[Data1277] = Ordering.by(_.id)
  def empty: Data1277 = Data1277(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1277 =
    Data1277(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1277] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
