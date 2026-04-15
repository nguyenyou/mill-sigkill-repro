package generated

final case class Data1196(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1196 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1196 = copy(value = value * k)
  def addTag(t: String): Data1196 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1196 = copy(meta = meta.updated(k, v))
  def merge(other: Data1196): Data1196 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1196 {
  given Ordering[Data1196] = Ordering.by(_.id)
  def empty: Data1196 = Data1196(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1196 =
    Data1196(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1196] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
