package generated

final case class Data1303(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1303 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1303 = copy(value = value * k)
  def addTag(t: String): Data1303 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1303 = copy(meta = meta.updated(k, v))
  def merge(other: Data1303): Data1303 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1303 {
  given Ordering[Data1303] = Ordering.by(_.id)
  def empty: Data1303 = Data1303(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1303 =
    Data1303(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1303] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
