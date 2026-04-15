package generated

final case class Data1306(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1306 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1306 = copy(value = value * k)
  def addTag(t: String): Data1306 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1306 = copy(meta = meta.updated(k, v))
  def merge(other: Data1306): Data1306 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1306 {
  given Ordering[Data1306] = Ordering.by(_.id)
  def empty: Data1306 = Data1306(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1306 =
    Data1306(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1306] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
