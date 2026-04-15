package generated

final case class Data1087(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1087 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1087 = copy(value = value * k)
  def addTag(t: String): Data1087 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1087 = copy(meta = meta.updated(k, v))
  def merge(other: Data1087): Data1087 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1087 {
  given Ordering[Data1087] = Ordering.by(_.id)
  def empty: Data1087 = Data1087(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1087 =
    Data1087(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1087] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
