package generated

final case class Data1203(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1203 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1203 = copy(value = value * k)
  def addTag(t: String): Data1203 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1203 = copy(meta = meta.updated(k, v))
  def merge(other: Data1203): Data1203 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1203 {
  given Ordering[Data1203] = Ordering.by(_.id)
  def empty: Data1203 = Data1203(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1203 =
    Data1203(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1203] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
