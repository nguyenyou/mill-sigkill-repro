package generated

final case class Data1425(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1425 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1425 = copy(value = value * k)
  def addTag(t: String): Data1425 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1425 = copy(meta = meta.updated(k, v))
  def merge(other: Data1425): Data1425 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1425 {
  given Ordering[Data1425] = Ordering.by(_.id)
  def empty: Data1425 = Data1425(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1425 =
    Data1425(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1425] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
