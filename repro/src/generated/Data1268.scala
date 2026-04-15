package generated

final case class Data1268(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1268 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1268 = copy(value = value * k)
  def addTag(t: String): Data1268 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1268 = copy(meta = meta.updated(k, v))
  def merge(other: Data1268): Data1268 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1268 {
  given Ordering[Data1268] = Ordering.by(_.id)
  def empty: Data1268 = Data1268(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1268 =
    Data1268(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1268] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
