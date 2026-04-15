package generated

final case class Data1394(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1394 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1394 = copy(value = value * k)
  def addTag(t: String): Data1394 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1394 = copy(meta = meta.updated(k, v))
  def merge(other: Data1394): Data1394 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1394 {
  given Ordering[Data1394] = Ordering.by(_.id)
  def empty: Data1394 = Data1394(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1394 =
    Data1394(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1394] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
