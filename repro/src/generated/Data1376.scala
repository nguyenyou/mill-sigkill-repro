package generated

final case class Data1376(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1376 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1376 = copy(value = value * k)
  def addTag(t: String): Data1376 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1376 = copy(meta = meta.updated(k, v))
  def merge(other: Data1376): Data1376 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1376 {
  given Ordering[Data1376] = Ordering.by(_.id)
  def empty: Data1376 = Data1376(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1376 =
    Data1376(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1376] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
