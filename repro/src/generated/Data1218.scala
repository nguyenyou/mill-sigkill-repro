package generated

final case class Data1218(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1218 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1218 = copy(value = value * k)
  def addTag(t: String): Data1218 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1218 = copy(meta = meta.updated(k, v))
  def merge(other: Data1218): Data1218 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1218 {
  given Ordering[Data1218] = Ordering.by(_.id)
  def empty: Data1218 = Data1218(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1218 =
    Data1218(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1218] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
