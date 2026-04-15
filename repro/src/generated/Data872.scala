package generated

final case class Data872(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data872 = copy(name = name.toUpperCase)
  def scale(k: Double): Data872 = copy(value = value * k)
  def addTag(t: String): Data872 = copy(tags = t :: tags)
  def put(k: String, v: String): Data872 = copy(meta = meta.updated(k, v))
  def merge(other: Data872): Data872 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data872 {
  given Ordering[Data872] = Ordering.by(_.id)
  def empty: Data872 = Data872(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data872 =
    Data872(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data872] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
